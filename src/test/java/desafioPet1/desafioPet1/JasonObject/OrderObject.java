package desafioPet1.desafioPet1.JasonObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderObject {

    private long id;
    private long petId;
    private int quantity;
    private String shipDate;
    private String status;
    private Boolean complete;

}
