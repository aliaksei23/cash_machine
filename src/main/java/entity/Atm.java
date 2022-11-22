package entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Atm {
    private Double atmBalance = 52000000.0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atm)) return false;

        Atm atm = (Atm) o;

        return this.getAtmBalance() != null ? this.getAtmBalance().equals(atm.getAtmBalance()) : atm.getAtmBalance() == null;
    }

    @Override
    public int hashCode() {
        return this.getAtmBalance() != null ? this.getAtmBalance().hashCode() : 0;
    }
}
