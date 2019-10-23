package seedu.address.model.task;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.classid.ClassId;

/**
 * Represents a Task in the calendar.
 */
public class Task {
    // Identity fields
    private final ClassId classId;
    private final Set<TaskTime> taskTimeSet = new HashSet<>();
    private final Marking marking;

    /**
     * Every field must be present and not null.
     */
    public Task(ClassId id, Set<TaskTime> taskTimes, Marking mark) {
        requireAllNonNull(id, taskTimes, mark);
        classId = id;
        taskTimeSet.addAll(taskTimes);
        marking = mark;
    }

    public ClassId getClassId() {
        return classId;
    }

    public Set<TaskTime> getTime() {
        return Collections.unmodifiableSet(taskTimeSet);
    }

    public Marking getMarking() {
        return marking;
    }


    /**
     * Returns true if both tasks has the same description.
     * This defines a weaker notion of equality between two tasks.
     */
    public boolean isSameTask(Task otherTask) {
        if (otherTask == this) {
            return true;
        }

        return otherTask != null
                && otherTask.getClassId().equals(getClassId());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Task)) {
            return false;
        }

        Task otherPerson = (Task) other;
        return otherPerson.getClassId().equals(getClassId())
                && otherPerson.getTime().equals(getTime())
                && otherPerson.getMarking().equals(getMarking());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(classId, taskTimeSet, marking);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Description: ")
                .append(getClassId())
                .append(" \nTime: ")
                .append(getTime() + "\n")
                .append(" Status: ")
                .append(getMarking());
        return builder.toString();
    }
}
