package com.example.fittoo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {
    private List<Workout> allWorkouts;
    private List<Workout> filteredWorkouts;
    private OnWorkoutClickListener listener;

    public interface OnWorkoutClickListener {
        void onWorkoutClick(Workout workout);
        void onStartWorkoutClick(Workout workout);
    }

    public WorkoutAdapter(List<Workout> workouts, OnWorkoutClickListener listener) {
        this.allWorkouts = workouts;
        this.filteredWorkouts = new ArrayList<>(workouts);
        this.listener = listener;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_card, parent, false);
        return new WorkoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        Workout workout = filteredWorkouts.get(position);
        holder.bind(workout);
    }

    @Override
    public int getItemCount() {
        return filteredWorkouts != null ? filteredWorkouts.size() : 0;
    }

    public void filter(String category, String difficultyLevel) {
        filteredWorkouts = new ArrayList<>();
        
        for (Workout workout : allWorkouts) {
            boolean matchesCategory = category.equals("All") || 
                                    workout.getCategory().equals(category);
            boolean matchesDifficulty = difficultyLevel.isEmpty() || 
                                       workout.getDifficultyLevel().equals(difficultyLevel);

            if (matchesCategory && matchesDifficulty) {
                filteredWorkouts.add(workout);
            }
        }
        
        notifyDataSetChanged();
    }

    class WorkoutViewHolder extends RecyclerView.ViewHolder {
        private ImageView workoutImage;
        private TextView workoutName;
        private TextView workoutDescription;
        private TextView workoutSets;
        private TextView workoutReps;
        private TextView workoutRestTime;
        private MaterialButton startWorkoutButton;

        public WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
            workoutImage = itemView.findViewById(R.id.workoutImage);
            workoutName = itemView.findViewById(R.id.workoutName);
            workoutDescription = itemView.findViewById(R.id.workoutDescription);
            workoutSets = itemView.findViewById(R.id.workoutSets);
            workoutReps = itemView.findViewById(R.id.workoutReps);
            workoutRestTime = itemView.findViewById(R.id.workoutRestTime);
            startWorkoutButton = itemView.findViewById(R.id.startWorkoutButton);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onWorkoutClick(filteredWorkouts.get(position));
                }
            });

            startWorkoutButton.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onStartWorkoutClick(filteredWorkouts.get(position));
                }
            });
        }

        public void bind(Workout workout) {
            workoutName.setText(workout.getName());
            workoutDescription.setText(workout.getDescription());
            workoutSets.setText(String.format("%d sets", workout.getSets()));
            workoutReps.setText(String.format("%d reps", workout.getReps()));
            workoutRestTime.setText(String.format("Rest: %s", workout.getRestTime()));
            int resourceId = itemView.getContext().getResources().getIdentifier(
                workout.getImageResource(), "drawable", itemView.getContext().getPackageName());
            if (resourceId != 0) {
                workoutImage.setImageResource(resourceId);
            } else {
                workoutImage.setImageResource(R.drawable.placeholder);
            }
        }
    }
}