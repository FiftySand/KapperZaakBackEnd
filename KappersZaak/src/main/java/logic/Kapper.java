package logic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import logic.interfaces.IKapper;
import repository.IKapperRepository;

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
    private String Name;
    @NotNull
    private Integer Age;

    @Transient
    private static IKapperRepository _kapperRepository;

    @Autowired
    private void set_kapperRepository(IKapperRepository kapperRepository) {
        _kapperRepository = kapperRepository;
    }

    public Kapper(Kapper kapper)
    {
        this.Id = kapper.getId();
        this.Name = kapper.getName();
        this.Age = kapper.getAge();
    }

    public Kapper(Kapper kapper, int id)
    {
        this.Id = id;
        this.Name = kapper.getName();
        this.Age = kapper.getAge();
    }

    public Kapper(int id, String name, int age)
    {
        Id = id;
        Name = name;
        Age = age;
    }

    public void update() {
        _kapperRepository.save(this);
    }
}
