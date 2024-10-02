package apimonedas.apimonedas.dominio;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "moneda")
public class Moneda {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_moneda")
    @GenericGenerator(name = "secuencia_moneda", strategy = "increment")
    private long id;
    @Column(name = "moneda", length = 100, unique = true)
    private String nombre;
    @Column(name = "sigla", length = 5, unique = true)
    private String sigla;
    @Column(name = "sigla", length = 5)
    private String simbolo;
    @Column(name = "moneda", length = 100)
    private String emisor;


}
