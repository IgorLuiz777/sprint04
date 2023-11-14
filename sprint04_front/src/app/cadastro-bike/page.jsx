
"use client"
import { useState } from 'react';
import './page.scss';

export default function CadastroBike() {
  const [selectedImages, setSelectedImages] = useState([]);
  
  const handleImageChange = (e) => {
    const files = e.target.files;
    const imageArray = Array.from(files);

    setSelectedImages(imageArray);
  };

  const handleImageUpload = () => {
    const imageNames = selectedImages.map((image) => image.name);
    localStorage.setItem('uploadedImages', JSON.stringify(imageNames));

    console.log('Imagens enviadas com sucesso!');
  };

  return (
    <main>
      <section className="content-cadastro-bike">
        <h2>Capture imagens da sua bicicleta inspirando-se nos exemplos abaixo:</h2>

        <p>Tire fotos da sua bicicleta em pé, em um ambiente bem iluminado, com o celular na horizontal.</p>

        <img src="bike-ex1.jpg" alt="exemplo bike" />
        <img src="bike-ex2.jpg" alt="exemplo bike" />

        <div className="upload">
          <h2>Faça o upload de imagens da sua bicicleta:</h2>
          <input
            type="file"
            accept="image/*"
            multiple
            onChange={handleImageChange}
          />
          <button onClick={handleImageUpload}>Enviar Imagens</button>
        </div>
      </section>
    </main>
  );
}
