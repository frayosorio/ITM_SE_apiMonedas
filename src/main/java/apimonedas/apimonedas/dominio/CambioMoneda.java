package apimonedas.apimonedas.dominio;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cambiomoneda")
public class CambioMoneda {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CambioMoneda_Secuencia")
    @GenericGenerator(name = "CambioMoneda_Secuencia", strategy = "increment")
    private long id;

    @ManyToOne
    @JoinColumn(name = "idmoneda", referencedColumnName = "id")
    private Moneda moneda;

    @Column(name = "valor")
    private double valor;

}
