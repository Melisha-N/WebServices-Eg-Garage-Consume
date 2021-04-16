package com.wolken.wolkenapp.garage_consume_webservices.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ConsumeGarageDTO {

	private int vehicleId;
	private int noOfWheels;
	private String type;
	private String color;

}
