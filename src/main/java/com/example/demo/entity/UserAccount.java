@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String role;
    private String department;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (role == null) role = "REVIEWER";
        createdAt = LocalDateTime.now();
    }

    // constructors, getters, setters
}
