/**
 * 
 */
package com.masai.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shahid
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Image {

	private String imageName;

	private String imageUrl;

}
