<header>
    <div>
        <h1 id="titelheader">Gaming products for sale</h1>
        <nav>
            <ul>
                <li ${param.actual eq 'home' ? "id = actual" : ""}>
                    <a href="ProductInformatie?command=home">Home</a></li>
                <li ${param.actual eq 'zoek' ? "id = actual" : ""}>
                    <a href="ProductInformatie?command=zoek">Search a product</a></li>
                <li ${param.actual eq 'voegToe' ? "id = actual" : ""}>
                    <a href="ProductInformatie?command=verkoop">Sell a product</a></li>
                <li ${param.actual eq 'overzicht' ? "id = actual" : ""}>
                    <a href="ProductInformatie?command=overzicht">Products for sale</a></li>
                <li ${param.actual eq 'logboek' ? "id = actual" : ""}>
                    <a href="ProductInformatie?command=logboekOverzicht">See logbook</a></li>
            </ul>
        </nav>
    </div>
</header>

