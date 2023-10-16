package seedu.address.model.student;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.studentscore.StudentScore;
import seedu.address.model.tag.Tag;


/**
 * Represents a Student in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Student {

    // Identity fields
    private final StudentId sid;

    private final StudentName name;
    private final StudentEmail email;
    private final TutorialGroup tg;
    private final List<StudentScore> scoreList = new ArrayList<>();

    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Student(StudentId sid, StudentName name, StudentEmail email, TutorialGroup tg,
                   List<StudentScore> scores, Set<Tag> tagSet) {
        requireAllNonNull(sid, name, email, tg);
        this.sid = sid;
        this.name = name;
        this.email = email;
        this.tg = tg;
        this.scoreList.addAll(scores);
        this.tags.addAll(tagSet);
    }

    public StudentId getStudentId() {
        return this.sid;
    }

    public StudentEmail getEmail() {
        return this.email;
    }

    public StudentName getName() {
        return this.name;
    }

    public TutorialGroup getTutorial() {
        return this.tg;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public List<StudentScore> getScores() {
        return Collections.unmodifiableList(scoreList);
    }
    public void addScoreToStudent(StudentScore score) {
        scoreList.add(score);
    }

    public void deleteScoreFromStudent(StudentScore score) {
        scoreList.remove(score);
    }

    /**
     * Returns true if both students have the same student ID.
     * This defines a weaker notion of equality between two students.
     */
    public boolean isSameStudent(Student otherStudent) {
        if (otherStudent == this) {
            return true;
        }

        return otherStudent != null
                && otherStudent.getStudentId().equals(getStudentId());
    }
    /**
     * Returns true if both students have the same identity and data fields.
     * This defines a stronger notion of equality between two students.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Student)) {
            return false;
        }

        Student otherPerson = (Student) other;
        return sid.equals(otherPerson.sid);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(sid);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("student id", sid)
                .toString();

    }

}
