import React, { useState } from "react";

const Register = () => {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: ""
  });

  const [errors, setErrors] = useState({
    name: "",
    email: "",
    password: ""
  });

  const [submitted, setSubmitted] = useState(false);

  // Validate on change (eventhandle)
  const validateField = (name, value) => {
    let errorMsg = "";
    switch (name) {
      case "name":
        if (value.trim().length < 5) {
          errorMsg = "Name must be at least 5 characters long.";
        }
        break;
      case "email":
        if (!value.includes("@") || !value.includes(".")) {
          errorMsg = "Email must contain both '@' and '.' characters.";
        }
        break;
      case "password":
        if (value.length < 8) {
          errorMsg = "Password must be at least 8 characters long.";
        }
        break;
      default:
        break;
    }
    setErrors((prev) => ({ ...prev, [name]: errorMsg }));
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
    validateField(name, value);
  };

  // Validate on submit (eventsubmit)
  const handleSubmit = (e) => {
    e.preventDefault();
    
    // Perform validation check on all fields
    const nameError = formData.name.trim().length < 5 ? "Name must be at least 5 characters long." : "";
    const emailError = (!formData.email.includes("@") || !formData.email.includes(".")) ? "Email must contain both '@' and '.' characters." : "";
    const passwordError = formData.password.length < 8 ? "Password must be at least 8 characters long." : "";

    setErrors({
      name: nameError,
      email: emailError,
      password: passwordError
    });

    if (nameError || emailError || passwordError) {
      alert("Validation failed. Please correct the errors in the form.");
      setSubmitted(false);
      return;
    }

    alert(`Registration Successful!\n\nName: ${formData.name}\nEmail: ${formData.email}`);
    setSubmitted(true);
  };

  return (
    <div style={{ fontFamily: "sans-serif", padding: "20px", maxWidth: "450px", margin: "20px auto", border: "1px solid #ccc", borderRadius: "8px", boxShadow: "0 2px 4px rgba(0,0,0,0.1)" }}>
      <h2 style={{ color: "#333", borderBottom: "2px solid #0275d8", paddingBottom: "8px", marginTop: 0 }}>
        Mail Registration Form
      </h2>
      <form onSubmit={handleSubmit} style={{ display: "flex", flexDirection: "column", gap: "15px", marginTop: "15px" }}>
        
        {/* Name Input */}
        <div style={{ display: "flex", flexDirection: "column", gap: "5px" }}>
          <label htmlFor="regName" style={{ fontWeight: "bold" }}>Name:</label>
          <input
            id="regName"
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
            placeholder="Enter your full name"
            style={{ padding: "8px", borderRadius: "4px", border: errors.name ? "1px solid red" : "1px solid #ccc" }}
            required
          />
          {errors.name && <span style={{ color: "red", fontSize: "12px" }}>{errors.name}</span>}
        </div>

        {/* Email Input */}
        <div style={{ display: "flex", flexDirection: "column", gap: "5px" }}>
          <label htmlFor="regEmail" style={{ fontWeight: "bold" }}>Email Address:</label>
          <input
            id="regEmail"
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Enter email address"
            style={{ padding: "8px", borderRadius: "4px", border: errors.email ? "1px solid red" : "1px solid #ccc" }}
            required
          />
          {errors.email && <span style={{ color: "red", fontSize: "12px" }}>{errors.email}</span>}
        </div>

        {/* Password Input */}
        <div style={{ display: "flex", flexDirection: "column", gap: "5px" }}>
          <label htmlFor="regPassword" style={{ fontWeight: "bold" }}>Password:</label>
          <input
            id="regPassword"
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            placeholder="Enter password"
            style={{ padding: "8px", borderRadius: "4px", border: errors.password ? "1px solid red" : "1px solid #ccc" }}
            required
          />
          {errors.password && <span style={{ color: "red", fontSize: "12px" }}>{errors.password}</span>}
        </div>

        <button
          type="submit"
          style={{
            padding: "10px",
            backgroundColor: "#0275d8",
            color: "#fff",
            border: "none",
            borderRadius: "4px",
            fontSize: "16px",
            fontWeight: "bold",
            cursor: "pointer",
            marginTop: "10px"
          }}
        >
          Register
        </button>
      </form>

      {submitted && (
        <p style={{ color: "green", textAlign: "center", fontWeight: "bold", marginTop: "15px" }}>
          Account Created Successfully!
        </p>
      )}
    </div>
  );
};

export default Register;
