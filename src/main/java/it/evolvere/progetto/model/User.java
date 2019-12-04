package it.evolvere.progetto.model;

import it.evolvere.progetto.model.dto.UserDto;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name = "utente")
public class User {

    @Id
    @NotNull
    @NotEmpty
    @Email
    private String username;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled=true;

    @Column
    private LocalDateTime createTime;


    public User() { }

    public User(UserDto userDto) {

        this.password = userDto.getPassword();
        this.username = userDto.getUsername();

    }

       /*
    @OneToOne
    private Gestore gestore;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "cliente_id")
    Set<Proforma> proforma;
     */


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


}

