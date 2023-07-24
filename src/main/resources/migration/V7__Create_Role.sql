CREATE TABLE roles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    roleName VARCHAR(255)  NULL,
    permission VARCHAR(255)  NULL,
    descriptions VARCHAR(255)  NULL,
    createdAt datetime(6) NOT NULL DEFAULT current_timestamp(6),
    updatedAt datetime(6) NOT NULL DEFAULT current_timestamp(6)
);
