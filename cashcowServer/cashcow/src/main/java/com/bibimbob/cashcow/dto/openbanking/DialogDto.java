package com.bibimbob.cashcow.dto.openbanking;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DialogDto {
    private long id;
    private long user_id;
    private String response;
    private String speaker;
    private String created_at;
    private String modified_at;
}
