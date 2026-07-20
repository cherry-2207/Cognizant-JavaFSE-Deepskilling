import React from "react";

const OfficeRental = () => {
  const primaryOffice = {
    name: "Premium Tech Park",
    rent: 75000,
    address: "Sector 5, Salt Lake, Kolkata",
    image: "/image1.png"
  };

  const officeList = [
    {
      name: "DNV Business Hub",
      rent: 55000,
      address: "New Town, Rajarhat, Kolkata",
      image: "/image2.png"
    },
    {
      name: "Co-Work Space Inc.",
      rent: 45000,
      address: "Park Street, Kolkata",
      image: "/image3.png"
    },
    {
      name: "Elite Corporate Center",
      rent: 85000,
      address: "EM Bypass, Kolkata",
      image: "/image1.png"
    }
  ];

  const getRentColor = (rent) => {
    return rent < 60000 ? "red" : "green";
  };

  return (
    <div style={{ fontFamily: "sans-serif", padding: "20px", maxWidth: "900px", margin: "0 auto" }}>
      <h1 style={{ textAlign: "center", color: "#333" }}>Office Space Rental App</h1>
      
      {/* Primary Office Section */}
      <div style={{ border: "2px solid #ddd", borderRadius: "8px", padding: "20px", marginBottom: "30px", display: "flex", gap: "20px", alignItems: "center" }}>
        <img
          src={primaryOffice.image}
          alt={primaryOffice.name}
          style={{ width: "250px", height: "150px", objectFit: "cover", borderRadius: "8px" }}
        />
        <div>
          <h2>Featured Office: {primaryOffice.name}</h2>
          <p><strong>Address:</strong> {primaryOffice.address}</p>
          <p>
            <strong>Monthly Rent: </strong>
            <span style={{ color: getRentColor(primaryOffice.rent), fontWeight: "bold", fontSize: "20px" }}>
              Rs {primaryOffice.rent}
            </span>
          </p>
        </div>
      </div>

      {/* Office Spaces List Section */}
      <h2>Available Office Spaces</h2>
      <div style={{ display: "grid", gridTemplateColumns: "repeat(auto-fill, minmax(250px, 1fr))", gap: "20px" }}>
        {officeList.map((office, idx) => (
          <div key={idx} style={{ border: "1px solid #ccc", borderRadius: "8px", overflow: "hidden", boxShadow: "0 2px 5px rgba(0,0,0,0.1)" }}>
            <img
              src={office.image}
              alt={office.name}
              style={{ width: "100%", height: "150px", objectFit: "cover" }}
            />
            <div style={{ padding: "15px" }}>
              <h3 style={{ margin: "0 0 10px 0" }}>{office.name}</h3>
              <p style={{ margin: "0 0 10px 0", fontSize: "14px", color: "#666" }}>
                <strong>Address:</strong> {office.address}
              </p>
              <p style={{ margin: 0 }}>
                <strong>Rent: </strong>
                <span style={{ color: getRentColor(office.rent), fontWeight: "bold" }}>
                  Rs {office.rent}
                </span>
              </p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default OfficeRental;
