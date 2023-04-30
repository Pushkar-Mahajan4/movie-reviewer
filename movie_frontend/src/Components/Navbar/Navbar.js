import "./Navbar.css";
import Button from "@mui/material/Button";

const Navbar = () => {
  return (
    <nav className="navbar-container">
      <img src="/Logo.png" alt="Logo" className="nav-image" />
      <ul>
        <li>
          <a href="#">Home</a>
        </li>
        <li>
          <a href="#">About</a>
        </li>
        <li>
          <a href="#">Services</a>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
