package com.travash.nigrani.Model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteLocation {

	private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
