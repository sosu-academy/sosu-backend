package com.academy.sosu.unit;

import com.academy.sosu.exception.DatabaseException;
import com.academy.sosu.repository.StudentRepository;
import com.academy.sosu.model.dto.student.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(MockitoExtension.class)
public class StudentRepositoryDbTest {
    @Mock
    StudentRepository studentRepository;

    @Nested
    @DisplayName("학생 생성")
    class CreateStudentTest {

        @BeforeEach
        void setUp() {
        }

        @Nested
        @DisplayName("정상 케이스")
        class SuccessCase {
            @Test
            @DisplayName("새로운 학생 생성")
            void createStudentSuccess() throws DatabaseException {

                //Given
                StudentDTO studentDTO = StudentDTO.builder()
                        .studentName("주홍민")
                        .school("노원고")
                        .birthYear("1992")
                        .parentPhoneNo1("01099306039")
                        .studentPhoneNo("01073929631")
                        .build();

                Long studentNo = 1L;

                //When
                Long result = studentRepository.insertStudent(studentDTO);

                //Then
//                assertThat(studentDTO.getStudentNo()).isEqualTo(studentNo);
                assertThat(result).isNotNull();
            }
        }
    }
}
