package com.d108.project.interfaces.api.favorate;

import com.d108.project.domain.favorite.favoriteBusinessArea.dto.FavoriteBusinessAreaRequestDto;
import com.d108.project.domain.favorite.favoriteBusinessArea.dto.FavoriteBusinessAreasResponseDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/favorite/business-areas")
public interface FavoriteBusinessAreaApi {

    @GetMapping("/list")
    ResponseEntity<List<FavoriteBusinessAreasResponseDto>> getFavoriteBusinessAreasByMember(@RequestParam Integer memberId);

    @DeleteMapping("{favoriteBusinessAreaId}")
    ResponseEntity<Object> deleteFavoriteBusinessArea(@RequestParam Integer memberId, @PathVariable Integer favoriteBusinessAreaId);

    @PostMapping
    ResponseEntity<Object> createFavoriteBusinessArea(@RequestParam Integer memberId, @RequestBody FavoriteBusinessAreaRequestDto favoriteBusinessAreaRequestDto);
}
