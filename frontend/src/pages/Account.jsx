import React, { useEffect, useState } from 'react';
import Navbar from '../components/Navbar';
import Footer from '../components/Footer';
import ButtonSign from '../components/ButtonSign';
import './Account.css';
import userImg from '../assets/login.svg';
import axios from "../../axiosConfig.js";
import { useNavigate } from "react-router-dom";
import MobileFooter from "../components/MobileFooter.jsx";

function Account() {
    const navigate = useNavigate();
    const [userInfo, setUserInfo] = useState({});

    const handleLogout = () => {
        window.localStorage.removeItem('token');
        navigate('/login');
    };

    const validateFile = (file) => {
        const allowedExtensions = ['.png', '.jpg'];
        const extension = file && file.name.toLowerCase().slice(-4);
        return file && allowedExtensions.includes(extension);
    };

    const handleFileUpload = async (event) => {
        event.preventDefault();
        const selectedFile = event.target.files[0];

        if (!validateFile(selectedFile)) {
            alert('Invalid file type. Please select a .png or .jpg file.');
            return;
        }

        const formData = new FormData();
        formData.append('file', selectedFile);

        try {
            await axios.post('/api/users/photo', formData, {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('token')}`
                }
            });
            fetchUserInfo();
        } catch (error) {
            console.error('Error uploading file:', error);
        }
    };

    const fetchUserInfo = async () => {
        try {
            const response = await axios.get('/api/users/info', {
                headers: {
                    Authorization: `Bearer ${localStorage.getItem('token')}`
                }
            });
            setUserInfo(response.data);
        } catch (error) {
            console.error('Error fetching user info:', error);
        }
    };

    useEffect(() => {
        fetchUserInfo();
    }, []);

    return (
        <div className="con">
            <Navbar />
            <div className="account-container">
                <form className="login" encType="multipart/form-data">
                    {userInfo.image ? (
                        <img className="userPhoto" src={`data:image/jpeg;base64,${userInfo.image}`} alt="User Image" />
                    ) : (
                        <img className="userPhoto" src={userImg} alt="User Image" />
                    )}
                    <p>{userInfo?.name || 'Login'}</p>
                    <div className="file-label">
                        <input type="file" name="file" onChange={handleFileUpload} />
                    </div>
                </form>
                <div className="data-container">
                    <ButtonSign color="lightPink" redirectTo="/myOrders">My Orders</ButtonSign>
                    <ButtonSign color="lightPink" redirectTo="/myAddress">My Address</ButtonSign>
                    <ButtonSign color="lightPink" onClick={handleLogout}>Log out</ButtonSign>
                </div>
            </div>
            <Footer />
            <div className='mobileFooter'>
                <MobileFooter />
            </div>
        </div>
    );
}

export default Account;
