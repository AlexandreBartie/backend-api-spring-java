package br.com.bartie.api.v1.view;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.bartie.app.core.ModelDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
@ToString
@JsonPropertyOrder({"id", "author", "title", "price", "launch"})
public class BookDTO extends ModelDTO<BookDTO> {

	private String author;
	private String title;
	private Date launch;
	private Double price;

}