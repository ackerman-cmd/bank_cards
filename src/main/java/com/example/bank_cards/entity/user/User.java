package com.example.bank_cards.entity.user;

import com.example.bank_cards.entity.card.Card;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role userRole;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Card> cards;

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(userRole);
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }
}
