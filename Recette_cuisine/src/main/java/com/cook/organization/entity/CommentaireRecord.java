package com.cook.organization.entity;

import java.time.LocalDate;

public record CommentaireRecord(String auteur, String commentaire, LocalDate date) {
}
