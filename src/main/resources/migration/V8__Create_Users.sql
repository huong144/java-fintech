CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    roleId int null,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    fullName VARCHAR(255)  NULL,
    phoneNumber VARCHAR(255)  NULL,
    address TEXT  NULL,
    dateOfBirth datetime(6)  NULL,
    sex VARCHAR(255)  NULL,
    avatar TEXT  NULL,
    email VARCHAR(255)  NULL,
    identityDocumentType VARCHAR(255)  NULL,
    identityNumber VARCHAR(255)  NULL,
    status VARCHAR(255)  NULL,
    isCustomer TINYINT NULL,
    createdAt datetime(6) NOT NULL DEFAULT current_timestamp(6),
    updatedAt datetime(6) NOT NULL DEFAULT current_timestamp(6)
);
