// CookieForm.jsx

import React from 'react';
import './CookieForm.css'; // Importujemy plik ze stylami
import Input from '../../components/Input'; // Import komponentu Input
import Navbar from '../../components/Navbar';
import Footer from '../../components/Footer';
import PrimaryButton from '../../components/PrimaryButton';
import Checkbox from '../../components/Checkbox';

function CookieForm() {
    return (
        <div className="con">
            <Navbar />
            <div className="cookieForm-container">
                <form className="cookieForm">
                    <Input label="Quantity (kg)" name="quantity" type="number" id="quantity" />
                    <p> Filling Type (max. 3)</p>
                    <div class="custom-checkboxes">
                        <Checkbox id="chocolate" label="Chocolate" value="chocolate" />
                        <Checkbox id="strawberry" label="Strawberry" value="strawberry" />
                        <Checkbox id="banana" label="Banana" value="banana" />
                        <Checkbox id="nutella" label="Nutella" value="nutella" />
                        <Checkbox id="lemon" label="Lemon" value="lemon" />
                        <Checkbox id="coconut" label="Coconut" value="coconut" />
                        <Checkbox id="caramel" label="Caramel" value="caramel" />
                        <Checkbox id="blueberry" label="Blueberry" value="blueberry" />
                        <Checkbox id="almond" label="Almond" value="almond" />
                        <Checkbox id="raspberry" label="Raspberry" value="raspberry" />
                        <Checkbox id="cherry" label="Cherry" value="cherry" />
                        <Checkbox id="vanilla" label="Vanilla" value="vanilla" />
                    </div>
                    <Input label="Main Colors" name="colors" type="text" id="colors" />
                    <p>Additional Options</p>
                    <div class="custom-checkboxes">
                        <Checkbox id="icing" label="Icing" value="icing" />
                        <Checkbox id="powdered_sugar" label="Powdered Sugar" value="powdered_sugar" />
                    </div>
                    <Input label="Delivery Date" name="date" type="text" id="deliveryDate" />
                    <Input label="Additional Info" name="additional_info" type="text" id="additional_info" />
                </form>
                <PrimaryButton type="submit" color="blue" redirectTo="/deliveryAddress">Next</PrimaryButton>
                <Footer />
            </div>
        </div>

    );
}

export default CookieForm;
