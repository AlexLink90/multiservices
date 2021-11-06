//package com.example.supportmodule.entities;
//
//import com.example.supportmodule.enums.OperationType;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class MathResultInfo {
//    private int operandOne;
//    private int operandTwo;
//    private OperationType operation;
//    private double result;
//}

package com.example.supportmodule.entities;

import ch.qos.logback.core.rolling.DefaultTimeBasedFileNamingAndTriggeringPolicy;
import com.example.supportmodule.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "operations")
public class MathResultInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "value1")
    private int operandOne;
    @Column(name = "value2")
    private int operandTwo;
    @Enumerated(EnumType.ORDINAL)
    private OperationType operation;
    private double result;
    @Column(name = "created_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @CreationTimestamp
    private Timestamp createdDate;
    @Column(name = "current_time_default",columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @CreationTimestamp
    private Timestamp timeDefault;

    public MathResultInfo(int id, int operandOne, int operandTwo, OperationType addition, int result) {
    }

    @PostPersist
    void setDate() {
        createdDate = new Timestamp(new Date().getTime());
    }
}
