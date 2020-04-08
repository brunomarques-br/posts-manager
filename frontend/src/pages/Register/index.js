import React from 'react';
import { FiArrowLeft } from 'react-icons/fi';
import { Link } from 'react-router-dom';

import './styles.css';

export default function Register() {
    return (
        <div className="register-container">
            <div className="content">
                <section>

                    <h1>Cadastro</h1>
                    <p>Faça seu cadastro, e entre na plataforma.</p>

                    <Link to="/" className="back-link">
                        <FiArrowLeft size={16} color="#164f78" />
                        Voltar para o Login
                    </Link>

                </section>
                <form>
                    <input placeholder="Nome" />

                    <input type="email" placeholder="E-mail"/>

                    <button className="button">Cadastrar</button>

                </form>
            </div>
        </div>
    );
}