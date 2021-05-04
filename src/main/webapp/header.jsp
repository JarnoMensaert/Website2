<header>
    <div>
        <h1 id="titelheader">Gamingproducten verkoop</h1>
        <nav>
            <ul>
                <li ${param.actual eq 'home' ? "id = actual" : ""}>
                    <a href="ProductInformatie?command=home">Home</a></li>
                <li ${param.actual eq 'zoek' ? "id = actual" : ""}>
                    <a href="ProductInformatie?command=zoek">Zoek een product</a></li>
                <li ${param.actual eq 'voegToe' ? "id = actual" : ""}>
                    <a href="ProductInformatie?command=verkoop">Verkoop een product</a></li>
                <li ${param.actual eq 'overzicht' ? "id = actual" : ""}>
                    <a href="ProductInformatie?command=overzicht">Producten te koop</a></li>
            </ul>
        </nav>
    </div>
</header>
