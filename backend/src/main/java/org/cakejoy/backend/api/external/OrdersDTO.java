package org.cakejoy.backend.api.external;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrdersDTO {
    private Integer id;
    private String occasion;
    private Double quantity;
    private Integer tiers;
    private String additionalInfo;
    private String colours;
    private Date date;
    private CategoryDTO category;
    private String state;
    private Integer score;
    private Set<FlavourDTO> flavours = new HashSet<>();
    private Set<AdditionalOptionsDTO> additionalOptions = new HashSet<>();
    private Set<GlazeDTO> glazes = new HashSet<>();
    private Set<OrderUserDTO> orderUsers = new HashSet<>();
    private Set<DecorationDTO> decoration = new HashSet<>();
    private Set<SprinkleDTO> sprinkle = new HashSet<>();

}


