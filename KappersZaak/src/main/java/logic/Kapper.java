package logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import logic.interfaces.IKapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Service
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Kapper implements IKapper{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @NotNull
    private String Username;
    @NotNull
    private String Password;
}
