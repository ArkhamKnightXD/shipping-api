package knight.arkham.shipping.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class Ship implements Serializable {

    private Long id;

    private String shipName;
    private String animeName;
    private String shipPhotoUrl;
    private String firstCharacterName;
    private String secondCharacterName;
    private String canonicalStatus;
    private String relationshipStatus;
    private String shipType;

    public Ship(String shipName, String animeName, String shipPhotoUrl, String firstCharacterName,
                String secondCharacterName, String canonicalStatus, String relationshipStatus, String shipType)
    {
        this.shipName = shipName;
        this.animeName = animeName;
        this.shipPhotoUrl = shipPhotoUrl;
        this.firstCharacterName = firstCharacterName;
        this.secondCharacterName = secondCharacterName;
        this.canonicalStatus = canonicalStatus;
        this.relationshipStatus = relationshipStatus;
        this.shipType = shipType;
    }
}