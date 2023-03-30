#pragma comment(linker, "/SUBSYSTEM:windows /ENTRY:WinMainCRTStartup")

#include <Windows.h>

// Data structure representing a celestial body
struct celestial_body {
    int x, y; // Position of center
    int radius; // Radius in pixels
    COLORREF color; // Color of body
    const wchar_t* name; // Name of celestial body
};

// Function to draw a celestial body
void draw_celestial_body(HDC hdc, celestial_body body) {
    HPEN pen = CreatePen(PS_SOLID, 2, body.color);
    HBRUSH brush = CreateSolidBrush(body.color);
    HPEN oldPen = (HPEN)SelectObject(hdc, pen);
    HBRUSH oldBrush = (HBRUSH)SelectObject(hdc, brush);
    Ellipse(hdc, body.x - body.radius, body.y - body.radius, body.x + body.radius, body.y + body.radius);

    SetTextColor(hdc, RGB(255, 255, 255));
    SetBkMode(hdc, TRANSPARENT);
    HFONT font = CreateFont(20, 0, 0, 0, FW_DONTCARE, FALSE, FALSE, FALSE, DEFAULT_CHARSET, OUT_OUTLINE_PRECIS,
        CLIP_DEFAULT_PRECIS, ANTIALIASED_QUALITY, VARIABLE_PITCH, TEXT("Arial"));
    HFONT oldFont = (HFONT)SelectObject(hdc, font);

    SIZE textSize;
    GetTextExtentPoint32(hdc, body.name, wcslen(body.name), &textSize);

    int textX = body.x - textSize.cx / 2;
    int textY = body.y - textSize.cy / 2;

    TextOut(hdc, textX, textY, body.name, wcslen(body.name));

    SelectObject(hdc, oldFont);
    SelectObject(hdc, oldPen);
    SelectObject(hdc, oldBrush);
    DeleteObject(font);
    DeleteObject(pen);
    DeleteObject(brush);
}

// Window message handling function
LRESULT CALLBACK WindowProc(HWND hwnd, UINT uMsg, WPARAM wParam, LPARAM lParam)
{
    // Define the Earth and Moon
    celestial_body earth = { 200, 200, 100, RGB(0, 0, 255), L"Earth" };
    celestial_body moon = { 350, 250, 25, RGB(200, 200, 200), L"Moon" };

    switch (uMsg)
    {
    case WM_PAINT:
    {
        // Initialize GDI
        PAINTSTRUCT ps;
        HDC hdc = BeginPaint(hwnd, &ps);

        // Draw the Earth and Moon
        draw_celestial_body(hdc, earth);
        draw_celestial_body(hdc, moon);

        // Clean up GDI resources
        EndPaint(hwnd, &ps);
        break;
    }
    case WM_DESTROY:
        PostQuitMessage(0);
        break;
    default:
        return DefWindowProc(hwnd, uMsg, wParam, lParam);
    }
    return 0;
}

// Application entry point
int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow)
{
    // Register window class
    WNDCLASS wc = {};
    wc.lpfnWndProc = WindowProc;
    wc.hInstance = hInstance;
    wc.lpszClassName = L"MyWindowClass";
    RegisterClass(&wc);

    // Create window
    HWND hwnd = CreateWindowEx(0,
        L"MyWindowClass",
        L"My Window",
        WS_OVERLAPPEDWINDOW | WS_VISIBLE,
        CW_USEDEFAULT, CW_USEDEFAULT,
        640, 480,
        NULL,
        NULL,
        hInstance,
        NULL);

    // Handle window messages
    MSG msg = {};
    while (GetMessage(&msg, NULL, 0, 0))
    {
        TranslateMessage(&msg);
        DispatchMessage(&msg);
    }

    return 0;
}
