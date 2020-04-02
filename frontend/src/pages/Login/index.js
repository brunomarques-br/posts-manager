import React from 'react';
import { FiLogIn } from 'react-icons/fi';
import { Link } from 'react-router-dom';

import './styles.css';
import statusReportBg from '../../assets/background-logo.png';

export default function Login() {
    return (

        <div className="login-container">
            <img src={statusReportBg} alt="Status Report 1.0" className="src" />
            <section className="form">

                <form onSubmit={() => { }}>

                    <h1>Área Restrita</h1>

                    <input placeholder="Sua Identificação" />

                    <button className="button" type="submit">Acessar</button>

                    <Link to="/register" className="back-link">
                        <FiLogIn size={16} color="#164f78" />
                        Não tenho cadastro.
                    </Link>

                </form>

            </section>

        </div>

    );
}