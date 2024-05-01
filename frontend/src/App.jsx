import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import SignUp from './pages/SignUp';
import Login from './pages/Login';
import Dashboard from './pages/Dashboard';
import ChooseCategory from './pages/ChooseCategory';
import CookieForm from './pages/forms/CookieForm';
import DeliveryAddress from './pages/DeliveryAddress';
import Success from './pages/Success';
import Account from './pages/Account';
import MyOrders from './pages/MyOrders';
import Order from './pages/Order';
import MyAddress from './pages/MyAddress';

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route exact path="/signUp" element={<SignUp />} />
          <Route exact path="/login" element={<Login />} />
          <Route exact path="/dashboard" element={<Dashboard />} />
          <Route exact path="/chooseCategory" element={<ChooseCategory />} />
          <Route exact path="/cookieForm" element={<CookieForm />} />
          <Route exact path="/deliveryAddress" element={<DeliveryAddress />} />
          <Route exact path="/success" element={<Success />} />
          <Route exact path="/account" element={<Account />} />
          <Route exact path="/myOrders" element={<MyOrders />} />
          <Route exact path="/order" element={<Order />} />
          <Route exact path="/myAddress" element={<MyAddress />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App; 
