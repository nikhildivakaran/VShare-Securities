<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>VShare Securities</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animations.css">
        <script src="${pageContext.request.contextPath}/js/font-loader.js"></script>
        <script src="${pageContext.request.contextPath}/js/index-pre.js"></script>
    </head>
    <body>
        <div>
            <div id="navbar">
                <h1>VSHARE SECURITIES</h1>
                <sec:authorize access="isAuthenticated()">
                    <span class="user-name">Welcome, <b>${user.firstName} ${user.lastName}</b></span>
                </sec:authorize>
                <img id="menu" src="${pageContext.request.contextPath}/images/svg/menu.svg" alt="Menu">
            </div>
            <div id="display-area">
                <div class="disparea-child" id="pane1">
                    <header><h1 style="font-size: 48px">Welcome To VShare!</h1></header>

                    <main role="main" style="font-size: 32px">
                        <p>
                            V Share is one the leading share brokers globally. V share is best financial site.Provides Live Market news, Commentary,Stock prices,IPO Analysis &Rating Free Portfolio to track investments.
                        </p>
                    </main>
                </div>K
                <div class="disparea-child" id="pane2">
                    <header><h1 style="font-size: 48px">Vision</h1></header>

                    <main role="main" style="font-size: 32px">
                        <p>
                            Our vision is to make Trading more accessible to every individual at all parts of the Globe.
                            In this digital era where network has been extremely easy to access we would like every individual to experience the ease of trading from where they are.
                            </p>
                    </main></div>
                <div class="disparea-child" id="pane3">
                    <header><h1 style="font-size: 48px">How is V-Share different from your regular share broker?</h1></header>

                    <main role="main" style="font-size: 32px">
                        <p>
                            V Share has a very user friendly website with a comfortable UI where you can get your get work done faster and with ease.
                            V share provides you with a unique and safe experience in its website. All the BUYERS and SELLERS are trusted and verified.*
                        </p>
                    </main></div>
                <div class="disparea-child" id="pane4">
                    <header><h1 style="font-size: 48px">About us</h1></header>

                    <main role="main" style="font-size: 32px">
                        <p>
                            We are relentlessly reimagining the world of tomorrow - one that is built on innovative ideas, fueled by market-moving insights and driven by forward thinking.
                            We are creating more market choice and opportunity to help unleash the dynamic, entrepreneurial spirit that drives the U.S. economy.
                        </p>
                    </main></div>
                <div id="status-bar">
                    <ul>
                        <li><a href="/info/termsofservice">Terms of service</a></li>
                        <li><a href="/info/privacypolicy">Privacy policy</a></li>
                        <li><a href="/info/support">Support</a></li>
                    </ul>
                    <ul>
                        <li><a href="/info/affiliate">Affiliate links</a></li>
                        <li><a href="/info/disclaimer">Disclaimer</a></li>
                    </ul>
                </div>
            </div>
            <div id="menu-container">
                <ul id="menu-items">
                    <sec:authorize access="isAnonymous()">
                        <li id="login-button">Login</li>
                        <li id="sign-up-button">Sign Up</li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li id="logout-button">Logout</li>
                    </sec:authorize>
                    <li id="about-button">About</li>
                </ul>
            </div>
        </div>
        <script src="/js/index-post.js"></script>
    </body>
</html>
