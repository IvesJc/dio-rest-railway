package me.dio.domain.dto;

import me.dio.domain.model.Account;
import me.dio.domain.model.Card;
import me.dio.domain.model.Feature;
import me.dio.domain.model.News;

import java.util.List;

public record UserDTO(
        String name,
        Account account,
        Card card,
        List<Feature> features,
        List<News> news
) {
}
