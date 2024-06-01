import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
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
import axios from '../axiosConfig';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [userRole, setUserRole] = useState('');

  useEffect(() => {
    const fetchUserInfo = async () => {
      try {
        const token = localStorage.getItem('token');
        if (!token) {
          console.error('No token found');
          return;
        }
        const response = await axios.get('/api/users/info', {
          headers: {
            Authorization: `Bearer ${token}`
          }
        });
        setIsLoggedIn(true);
        setUserRole(response.data.role.name);
        console.log('User info fetched successfully:', response.data);
      } catch (error) {
        console.error('Error fetching user info:', error);
      }
    };

    fetchUserInfo();
  }, []);

  const ProtectedRoute = ({ element, ...rest }) => {
    return isLoggedIn ? element : <Navigate to="/login" />;
  };

  const BakerRoute = ({ element, ...rest }) => {
    return isLoggedIn && userRole === 'baker' ? element : <Navigate to="/login" />;
  };

  return (
      <Router>
        <CategoryProvider>
          <div>
            <Routes>
              <Route exact path="/signUp" element={<SignUp />} />
              <Route exact path="/login" element={<Login />} />
              <Route exact path="/dashboard" element={<ProtectedRoute element={<Dashboard />} />} />
              <Route exact path="/chooseCategory" element={<ProtectedRoute element={<ChooseCategory />} />} />
              <Route exact path="/cookiesForm" element={<ProtectedRoute element={<CookieForm />} />} />
              <Route exact path="/cupcakesForm" element={<ProtectedRoute element={<CupcakeForm />} />} />
              <Route exact path="/donutsForm" element={<ProtectedRoute element={<DonutForm />} />} />
              <Route exact path="/cakesForm" element={<ProtectedRoute element={<CakeForm />} />} />
              <Route exact path="/deliveryAddress" element={<ProtectedRoute element={<DeliveryAddress />} />} />
              <Route exact path="/success" element={<ProtectedRoute element={<Success />} />} />
              <Route exact path="/account" element={<ProtectedRoute element={<Account />} />} />
              <Route exact path="/myOrders" element={<ProtectedRoute element={<MyOrders />} />} />
              <Route exact path="/order/:orderId" element={<ProtectedRoute element={<Order />} />} />
              <Route exact path="/myAddress" element={<ProtectedRoute element={<MyAddress />} />} />
              <Route exact path="/clientsOrders" element={<BakerRoute element={<ClientsOrders />} />} />
              <Route exact path="/clientOrder/:orderId" element={<BakerRoute element={<ClientOrder />} />} />
              <Route exact path="/accountBaker" element={<BakerRoute element={<AccountBaker />} />} />
            </Routes>
          </div>
        </CategoryProvider>
      </Router>
  );
}

export default App;
