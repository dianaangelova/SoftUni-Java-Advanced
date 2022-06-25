package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exerciseCount > exercises.size()) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        boolean exerciseExists = false;
        Exercise exercise = null;
        for (Exercise e : exercises) {
            if (e.getName().equals(name) && e.getMuscle().equals(muscle)) {
                exercise = e;
                exerciseExists = true;
            }
        }
        if (exerciseExists) {
            exercises.remove(exercise);
        }

        return exerciseExists;
    }

    public Exercise getExercise(String name, String muscle) {
        Exercise exercise = null;
        for (Exercise e : exercises) {
            if (e.getName().equals(name) && e.getMuscle().equals(muscle)) {
                exercise = e;
            }
        }
        return exercise;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s%n", type));
        for (Exercise e : exercises) {
            sb.append(String.format("%s%n", e.toString()));
        }
        return sb.toString().trim();

    }


}
