package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
@Builder
public class Category {

	
	 @Id
	    @Column(name = "category_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer categoryId;

	    public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

		@Column(name="category_name")
	    private String categoryName;
}
