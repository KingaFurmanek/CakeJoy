import React, { useEffect, useState } from 'react';
import './Forms.css';
import Input from '../../components/Input';
import Navbar from '../../components/Navbar';
import Footer from '../../components/Footer';
import PrimaryButton from '../../components/PrimaryButton';
import Checkbox from '../../components/Checkbox';
import { useCategory } from '../../components/CategoryContext.jsx';
import axios from '../../../axiosConfig';

function CookieForm() {
    const { chosenCategory } = useCategory();

    const [formData, setFormData] = useState({
        quantity: '',
        flavours: [],
        colours: '',
        additionalOptions: [],
        date: '',
        additionalInfo: '',
        userId: '',
        category: chosenCategory
    });

    useEffect(() => {
        const fetchUserData = async () => {
            try {
                const response = await axios.get('/api/users/info', {
                    headers: {
                        Authorization: `Bearer ${localStorage.getItem('token')}`
                    }
                });
                const userData = response.data;
                setFormData((prevFormData) => ({
                    ...prevFormData,
                    userId: userData.id
                }));
            } catch (error) {
                console.error('Error fetching user data:', error);
            }
        };
        fetchUserData();
    }, []);

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('/api/orders/submit', formData);
            console.log('Order submitted successfully:', response.data);
        } catch (error) {
            console.error('Error submitting order:', error);
        }
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleCheckboxChange = (e) => {
        const { name, checked, value } = e.target;
        if (checked) {
            setFormData({ ...formData, [name]: [...formData[name], value] });
        } else {
            setFormData({ ...formData, [name]: formData[name].filter((item) => item !== value) });
        }
    };

    return (
        <div className="con">
            <Navbar />
            <div className="form-container">
                <form className="form-details" onSubmit={handleSubmit}>
                    <Input label="Quantity (kg)" name="quantity" type="number" id="quantity" value={formData.quantity} onChange={handleChange} />
                    <p> Filling Type (max. 3)</p>
                    <div className="custom-checkboxes">
                        <Checkbox id="chocolate" label="Chocolate" value="chocolate" name="flavours" checked={formData.flavours.includes('chocolate')} onChange={handleCheckboxChange} />
                        <Checkbox id="strawberry" label="Strawberry" value="strawberry" name="flavours" checked={formData.flavours.includes('strawberry')} onChange={handleCheckboxChange} />
                        <Checkbox id="banana" label="Banana" value="banana" name="flavours" checked={formData.flavours.includes('banana')} onChange={handleCheckboxChange} />
                        <Checkbox id="nutella" label="Nutella" value="nutella" name="flavours" checked={formData.flavours.includes('nutella')} onChange={handleCheckboxChange} />
                        <Checkbox id="lemon" label="Lemon" value="lemon" name="flavours" checked={formData.flavours.includes('lemon')} onChange={handleCheckboxChange} />
                        <Checkbox id="coconut" label="Coconut" value="coconut" name="flavours" checked={formData.flavours.includes('coconut')} onChange={handleCheckboxChange} />
                        <Checkbox id="caramel" label="Caramel" value="caramel" name="flavours" checked={formData.flavours.includes('caramel')} onChange={handleCheckboxChange} />
                        <Checkbox id="blueberry" label="Blueberry" value="blueberry" name="flavours" checked={formData.flavours.includes('blueberry')} onChange={handleCheckboxChange} />
                        <Checkbox id="almond" label="Almond" value="almond" name="flavours" checked={formData.flavours.includes('almond')} onChange={handleCheckboxChange} />
                        <Checkbox id="raspberry" label="Raspberry" value="raspberry" name="flavours" checked={formData.flavours.includes('raspberry')} onChange={handleCheckboxChange} />
                        <Checkbox id="cherry" label="Cherry" value="cherry" name="flavours" checked={formData.flavours.includes('cherry')} onChange={handleCheckboxChange} />
                        <Checkbox id="vanilla" label="Vanilla" value="vanilla" name="flavours" checked={formData.flavours.includes('vanilla')} onChange={handleCheckboxChange} />
                    </div>
                    <Input label="Main Colors" name="colours" type="text" id="colours" value={formData.colours} onChange={handleChange} />
                    <p>Additional Options</p>
                    <div className="custom-checkboxes">
                        <Checkbox id="icing" label="Icing" value="icing" name="additionalOptions" checked={formData.additionalOptions.includes('icing')} onChange={handleCheckboxChange} />
                        <Checkbox id="powdered sugar" label="Powdered Sugar" value="powdered sugar" name="additionalOptions" checked={formData.additionalOptions.includes('powdered sugar')} onChange={handleCheckboxChange} />
                        <Checkbox id="none" label="None" value="none" name="additionalOptions" checked={formData.additionalOptions.includes('none')} onChange={handleCheckboxChange} />
                    </div>
                    <Input label="Delivery Date" name="date" type="text" id="deliveryDate" value={formData.date} onChange={handleChange} />
                    <Input label="Additional Info" name="additionalInfo" type="text" id="additionalInfo" value={formData.additionalInfo} onChange={handleChange} />
                    <PrimaryButton type="submit" color="blue" redirectTo="/success">Next</PrimaryButton>
                </form>
                <Footer />
            </div>
        </div>
    );
}

export default CookieForm;
