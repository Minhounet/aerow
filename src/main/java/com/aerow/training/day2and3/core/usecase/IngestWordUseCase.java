package com.aerow.training.day2and3.core.usecase;

/**
 * Sauvegarder le mot dans une base
 * - un identifiant unique
 * - taille du mot
 *
 * Renvoyer l'identifiant créé
 *
 * planter si le mot existe déjà, voir {@link com.aerow.training.day2and3.core.usecase.exception.WordAlreadyExistException}.
 */
public interface IngestWordUseCase {

    IngestWordUseCaseResponse ingestWord(IngestWordUseCaseRequest word);
}
