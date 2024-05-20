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
import ClientsOrders from './pages/ClientsOrders';
import ClientOrder from './pages/ClientOrder';
import AccountBaker from './pages/AccountBaker';
import { CategoryProvider } from './components/CategoryContext';
import CupcakeForm from "./pages/forms/CupcakeForm.jsx";
import DonutForm from "./pages/forms/DonutForm.jsx";
import CakeForm from "./pages/forms/CakeForm.jsx";

function App() {
  return (
    <Router>
      <CategoryProvider>
      <div>
        <Routes>
          <Route exact path="/signUp" element={<SignUp />} />
          <Route exact path="/login" element={<Login />} />
          <Route exact path="/dashboard" element={<Dashboard />} />
          <Route exact path="/chooseCategory" element={<ChooseCategory />} />
          <Route exact path="/cookiesForm" element={<CookieForm />} />
          <Route exact path="/cupcakesForm" element={<CupcakeForm />} />
          <Route exact path="/donutsForm" element={<DonutForm />} />
          <Route exact path="/cakesForm" element={<CakeForm />} />
          <Route exact path="/deliveryAddress" element={<DeliveryAddress />} />
          <Route exact path="/success" element={<Success />} />
          <Route exact path="/account" element={<Account />} />
          <Route exact path="/myOrders" element={<MyOrders />} />
          <Route exact path="/order/:orderId" element={<Order />} />
          <Route exact path="/myAddress" element={<MyAddress />} />
          <Route exact path="/clientsOrders" element={<ClientsOrders />} />
          <Route exact path="/clientOrder/:orderId" element={<ClientOrder />} />
          <Route exact path="/accountBaker" element={<AccountBaker />} />
        </Routes>
      </div>
      </CategoryProvider>
    </Router>
  );
}

export default App; 
