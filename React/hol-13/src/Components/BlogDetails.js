import React from "react";

const BlogDetails = () => {
  const blogs = [
    { title: "Understanding React State", date: "July 12, 2026", reads: "1.2k" },
    { title: "Why CSS Modules are Awesome", date: "July 15, 2026", reads: "850" },
    { title: "A Guide to React Router v6", date: "July 18, 2026", reads: "2.1k" }
  ];

  return (
    <div style={{ padding: "15px", border: "1px solid #5cb85c", borderRadius: "5px", backgroundColor: "#f4fdf4" }}>
      <h3 style={{ color: "#5cb85c", marginTop: 0 }}>Blog Details</h3>
      <div style={{ display: "flex", flexDirection: "column", gap: "10px" }}>
        {blogs.map((blog, idx) => (
          <div key={idx} style={{ borderBottom: "1px solid #eee", paddingBottom: "8px" }}>
            <h4 style={{ margin: "0 0 5px 0" }}>{blog.title}</h4>
            <span style={{ fontSize: "12px", color: "#888" }}>Published: {blog.date} | Reads: {blog.reads}</span>
          </div>
        ))}
      </div>
    </div>
  );
};

export default BlogDetails;
