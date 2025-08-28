package com.aerow.training.day2.mock.p2;

/*
 * Sauvegarder "id" dans une base Ipssi king et renvoyer vrai
 * Ne pas le faire si déjà présent et renvoyer faux.
 */
public class AerowUseCase {

    private final IpssiRepository ipssiRepository;

    public AerowUseCase(IpssiRepository ipssiRepository) {
        this.ipssiRepository = ipssiRepository;
    }

    boolean register(String id) {
        boolean idAlreadyRegistered = ipssiRepository.exists(id);
        if (!idAlreadyRegistered) {
            ipssiRepository.save("ipssi");
        }
       return !idAlreadyRegistered;
    }

}
