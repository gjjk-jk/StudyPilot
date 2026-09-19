package com.wym.studypilot.mapper;

import com.wym.studypilot.model.StudyTask;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select("SELECT * FROM study_task")
    List<StudyTask> findAll();

    @Select("SELECT * FROM study_task WHERE id = #{id}")
    StudyTask findById(Long id);

    @Insert("""
            INSERT INTO study_task(title, description, completed)
            VALUES(#{title}, #{description}, #{completed})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(StudyTask task);

    @Update("""
            UPDATE study_task
            SET title = #{title},
                description = #{description},
                completed = #{completed}
            WHERE id = #{id}
            """)
    int update(StudyTask task);

    @Delete("DELETE FROM study_task WHERE id = #{id}")
    int deleteById(Long id);
}