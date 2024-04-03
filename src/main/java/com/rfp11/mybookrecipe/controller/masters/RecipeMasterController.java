package com.rfp11.mybookrecipe.controller.masters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rfp11.mybookrecipe.dto.CategoriesDTO;
import com.rfp11.mybookrecipe.dto.response.ListResponse;
import com.rfp11.mybookrecipe.service.CategoriesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lib.i18n.utility.MessageUtil;

@Tag(name = "Book Recipe Master", description = "Book recipe master management APIs")
@RestController
@RequestMapping("/book-recipe-masters")
public class RecipeMasterController {
    @Autowired
    private CategoriesService categoryService;

    @Autowired
    private MessageUtil messageUtil;

    @Operation(summary = "Retrieve Category Option List", description = "Get List of Master Data Category")
    @GetMapping("/category-option-lists")
    public ResponseEntity<ListResponse<CategoriesDTO>> getCategoryOptions() {
        List<CategoriesDTO> categoryDTOs = categoryService.getAllCategories().stream()
                .map(category -> new CategoriesDTO(category.getCategoryId(), category.getCategoryName()))
                .collect(Collectors.toList());

        ListResponse<CategoriesDTO> response = new ListResponse<>(categoryDTOs,
                messageUtil.get("application.success.get"), HttpStatus.OK.value(), "Success");
        return ResponseEntity.ok(response);
    }

}
