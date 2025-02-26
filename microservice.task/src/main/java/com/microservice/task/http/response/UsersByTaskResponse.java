package com.microservice.task.http.response;

<<<<<<< HEAD
public class UsersByTaskResponse {
=======
import com.microservice.task.dto.UserDto;
import com.microservice.task.entities.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersByTaskResponse {

    private String title;
    private TaskStatus status;
    private List<UserDto> userDTOList;

>>>>>>> feature/user-service
}
