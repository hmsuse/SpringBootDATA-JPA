import React from 'react';
import { Link, NavLink } from 'react-router-dom';
function Header(){
return(
    <div>
    <header>
        <nav className="navbar navbar-expand-md navbar-dark  header">
        <div><img src='images/home1.jpeg' width='40px' height='40px'/><a href="" className="navbar-brand">Hostel Management System</a></div>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <ul className="navbar-nav ml-auto">
      <li class="nav-item active">
        <NavLink className="nav-link" to="/users">Users <span class="sr-only">(current)</span></NavLink>
      </li>
      <li class="nav-item">
          <NavLink className="nav-link" to='/guests'>Gustes</NavLink> 
      </li>
      <li class="nav-item">
          <NavLink className="nav-link" to='/floors'>Rooms</NavLink> 
      </li>
     
    </ul> 
  </div>
        </nav>
    </header>
</div>
)
}
export default Header;