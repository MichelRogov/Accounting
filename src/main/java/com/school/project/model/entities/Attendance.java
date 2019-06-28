package com.school.project.model.entities;

import com.school.project.base.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ATTENDANCE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attendance extends AbstractBaseEntity {

    @OneToOne
    @JoinColumn(name = "LESSON_ID", nullable = false)
    private Lesson lesson;

    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "IS_PRESENT")
    private boolean isPresent;

}
